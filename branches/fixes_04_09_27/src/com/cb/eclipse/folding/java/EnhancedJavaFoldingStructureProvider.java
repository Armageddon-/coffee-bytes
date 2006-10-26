/*******************************************************************************
 * Copyright (c) 2004 Coffee-Bytes.com and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.opensource.org/licenses/cpl.php
 * 
 * Contributors:
 *     Coffee-Bytes.com - initial API and implementation
 *******************************************************************************/
package com.cb.eclipse.folding.java;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.IElementChangedListener;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaElementDelta;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.ui.javaeditor.ClassFileEditor;
import org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor;
import org.eclipse.jdt.internal.ui.javaeditor.IClassFileEditorInput;
import org.eclipse.jdt.internal.ui.javaeditor.JavaEditor;
import org.eclipse.jdt.ui.IWorkingCopyManager;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jdt.ui.text.folding.IJavaFoldingStructureProvider;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.projection.IProjectionListener;
import org.eclipse.jface.text.source.projection.ProjectionAnnotationModel;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

import com.cb.eclipse.folding.FoldingPlugin;
import com.cb.eclipse.folding.java.calculation.ProjectionChangeReconciler;

/**
 * Implementation of the FoldingStructureProvider extension point that provides
 * many projection options.
 * 
 * @author RJ
 */
public class EnhancedJavaFoldingStructureProvider implements IJavaFoldingStructureProvider {
    private static final ILog L = FoldingPlugin.getDefault().getLog();

    private IDocumentProvider provider;
    private IDocument document;
	private ITextEditor editor;
	private IJavaElement input;
	private ProjectionViewer viewer;
	private ProjectionListener projectionListener;
	private ElementChangedListener elementChangedListener;
	private ProjectionChangeReconciler reconciler;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jdt.ui.text.folding.IJavaFoldingStructureProvider#install(org.eclipse.ui.texteditor.ITextEditor,
	 *      org.eclipse.jface.text.source.projection.ProjectionViewer)
	 */
	public void install(ITextEditor editor, ProjectionViewer viewer) {
		if (supports(editor)) {
			this.editor = editor;
			this.viewer = viewer;
            this.provider= editor.getDocumentProvider();
            this.document= this.provider.getDocument(editor.getEditorInput());

			this.projectionListener = new ProjectionListener();
			this.elementChangedListener = new ElementChangedListener();
			this.reconciler = new ProjectionChangeReconciler();
			this.viewer.addProjectionListener(projectionListener);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jdt.ui.text.folding.IJavaFoldingStructureProvider#uninstall()
	 */
	public void uninstall() {
		if (isInstalled()) {
			this.projectionListener.projectionDisabled();
			this.viewer.removeProjectionListener(projectionListener);
			this.projectionListener = null;
			this.viewer = null;
			this.editor = null;
            this.input= null;
            this.document= null;
            this.provider= null;
		}

	}

    private boolean hasDocument() {
        return this.document != null;
    }
    
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jdt.ui.text.folding.IJavaFoldingStructureProvider#initialize()
	 */
	public void initialize() {
		if (!isInstalled()) { return; }

        if (!supports(this.editor)) { return; }

        if (!hasDocument()) { return; }
        
		try {
			cacheDoc(this.document);

			if (editor instanceof CompilationUnitEditor) {
                IWorkingCopyManager manager = JavaUI.getWorkingCopyManager();
//				IWorkingCopyManager manager = JavaPlugin.getDefault().getWorkingCopyManager();
				input = manager.getWorkingCopy(editor.getEditorInput());
			}
			else if (editor instanceof ClassFileEditor) {
				IClassFileEditorInput editorInput = (IClassFileEditorInput) editor.getEditorInput();
				input = editorInput.getClassFile();
			}

			if (input != null) {
				ProjectionAnnotationModel model = (ProjectionAnnotationModel) editor.getAdapter(ProjectionAnnotationModel.class);
				
				if(null != model) {
					reconciler.initialize(model, input);
				}
			}

		}
		finally {
			releaseDoc();
		}
	}

	public void release() {
		releaseDoc();
	}

	protected boolean supports(ITextEditor editor) {
		return (editor instanceof JavaEditor);
	}

	private boolean isInstalled() {
		return editor != null;
	}

	private void cacheDoc(IDocument doc) {
		reconciler.setCurrentDocument(doc);
	}

	private void releaseDoc() {
		reconciler.setCurrentDocument(null);

	}

	private class ElementChangedListener implements IElementChangedListener {

		public void elementChanged(ElementChangedEvent event) {
            if(!hasDocument()) return;
            
			ProjectionAnnotationModel model = (ProjectionAnnotationModel) editor.getAdapter(ProjectionAnnotationModel.class);
			
			if (!isInstalled() ||  model == null || !isValidEvent(event.getDelta())) {
				return;
            }

			try {
				cacheDoc(EnhancedJavaFoldingStructureProvider.this.document);
				reconciler.reconcile(model, (IJavaElement) input);
			}
			finally {
				releaseDoc();
			}
			
		}
		
		private boolean isValidEvent(IJavaElementDelta delta) {
					
			if (delta == null || delta.getElement().getElementType() > IJavaElement.CLASS_FILE) {
				return false;
			}			
			
			if(input.equals(delta.getElement())) {
				return true;
			}
			
			IJavaElementDelta[] children= delta.getAffectedChildren();
			if (children == null || children.length == 0)
				return false;

			boolean childResult = false;
			for (int i= 0; i < children.length; i++) {
				childResult = childResult || isValidEvent(children[i]);				
			}
			
			return childResult;
		}
		
	}

	private class ProjectionListener implements IProjectionListener {
		public void projectionEnabled() {
			projectionDisabled();

			if (supports(editor)) {
				initialize();
				JavaCore.addElementChangedListener(elementChangedListener);
			}
		}

		public void projectionDisabled() {
            JavaCore.removeElementChangedListener(elementChangedListener);
			release();
		}
	}
}