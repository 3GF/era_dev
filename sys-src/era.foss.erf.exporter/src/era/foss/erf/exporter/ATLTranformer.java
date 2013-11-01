/**************************************************************************
 * ERA - Eclipse Requirements Analysis
 * ==============================================
 * Copyright (C) 2009-2013 by Georg Blaschke, Christoph P. Neumann
 * and Bernd Haberstumpf (http://era.origo.ethz.ch)
 **************************************************************************
 * Licensed under the Eclipse Public License - v 1.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.eclipse.org/org/documents/epl-v10.html
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **************************************************************************
*/
package era.foss.erf.exporter;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.m2m.atl.drivers.emf4atl.EMFModelLoader;
import org.eclipse.m2m.atl.engine.vm.AtlLauncher;
import org.eclipse.m2m.atl.engine.vm.AtlModelHandler;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

/**
 * Wrapper around the ATL Transformer to.
 * 
 */
public class ATLTranformer {

    //
    // private members

    /** Caches the model loader. */
    private EMFModelLoader loader = null;

    /** All parsed and outputed models (changed by loadModel and createModel). */
    private Map<String, ASMModel> models = new HashMap<String, ASMModel>();

    /**
     * Instantiates a new aTL tranformer.
     */
    public ATLTranformer() {
    }

    /**
     * Load a model.
     * 
     * Loaded models are added to {@link #models}.
     * 
     * @param modelId a unique id to identify the model during this transformation
     * @param metaModelId the meta model id
     * @param modelPath the model path
     * @return the parsed model
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void loadModel( String modelId, String metaModelId, URI modelPath ) throws IOException {
        EMFModelLoader ml = getModelLoader();
        ASMModel metaModel;
        ASMModel model;

        // Meta model
        if( metaModelId == null ) {
            metaModel = ml.getMOF();
        } else {
            metaModel = models.get( metaModelId );
        }
        if( metaModel == null ) throw new IllegalStateException( "metaModel " + metaModelId + " not loaded" );

        // Model
        model = loadModel( modelId, metaModel, modelPath );
        models.put( modelId, model );
    }

    /**
     * Run the model transformation.
     * 
     * @param asmPath the asm path
     * @param outputId id of the output model
     * @param outputPath path to output file
     * @param outputMetaModelId id of a previously loaded meta model or null for MOF
     * @param saveModel true to save the model
     * @return the resource
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public Resource transform( String asmPath, String outputId, URI outputPath, String outputMetaModelId, boolean saveModel )
            throws IOException {
        createModel( outputId, outputMetaModelId, outputPath );

        AtlLauncher myLauncher = AtlLauncher.getDefault();
        myLauncher.launch( new URL( asmPath ),
                           Collections.EMPTY_MAP,
                           models,
                           Collections.EMPTY_MAP,
                           Collections.EMPTY_LIST,
                           Collections.EMPTY_MAP );
        if( saveModel ) saveModel( outputId, outputPath );        
        ASMModel outModel = models.remove( outputId );
        return ((ASMEMFModel)outModel).getExtent();
    }

    //
    // Internal helpers

    /**
     * Create the model loader.
     * 
     * @return the mode loader
     */
    private EMFModelLoader getModelLoader() {
        if( loader != null ) return loader;
        return loader = (EMFModelLoader)AtlModelHandler.getDefault( "EMF" ).createModelLoader();
    }

    /**
     * Called by {@link #loadModel(String, String, String)} to load a model.
     * 
     * Loaded models are added to {@link #models}.
     * 
     * @param modelId a unique id to identify the model during this transformation
     * @param metaModel the parsed meta model
     * @param path the workspace relative path to the model file
     * @return the parsed model
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private ASMModel loadModel( String modelId, ASMModel metaModel, URI path ) throws IOException {
        return ( getModelLoader() ).loadModel( modelId, metaModel, path );
    }

    /**
     * Create a new emtpy model for the given meta model.
     * 
     * Created models are added to {@link #models}.
     * 
     * @param modelId A unique id during this transformation for the new model
     * @param metaModel the meta model of the model
     * @param path the path to which the model shall be saved
     * @return the model
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private ASMModel createModel( String modelId, ASMModel metaModel, URI path ) throws IOException {
        return ( getModelLoader() ).newModel( modelId, path.toString(), metaModel );
    }

    /**
     * Create a new emtpy model for the given meta model.
     * 
     * Created models are added to {@link #models}.
     * 
     * @param modelId A unique id during this transformation for the new model
     * @param metaModelId the meta model id
     * @param modelPath the model path
     * @return the model
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private ASMModel createModel( String modelId, String metaModelId, URI modelPath ) throws IOException {
        EMFModelLoader ml = getModelLoader();
        ASMModel metaModel;

        // Meta model
        if( metaModelId == null ) {
            metaModel = ml.getMOF();
        } else {
            metaModel = models.get( metaModelId );
        }

        if( metaModel == null ) throw new IllegalStateException( "metaModel " + metaModelId + " not loaded" );

        // Model
        ASMModel outputModel = createModel( modelId, metaModel, modelPath );
        if( outputModel instanceof ASMEMFModel ) ( (ASMEMFModel)outputModel ).setCheckSameModel( false );
        models.put( modelId, outputModel );

        return outputModel;
    }

    /**
     * Save a model to disk.
     * 
     * @param outputModelId Id of a previously loaded or created model.
     * @param outputPath the path to a workspace file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void saveModel( String outputModelId, URI outputPath ) throws IOException {
        ASMModel outputModel = models.get( outputModelId );
        getModelLoader().save( outputModel, outputPath.toString() );
    }

} // ATLTranformer
