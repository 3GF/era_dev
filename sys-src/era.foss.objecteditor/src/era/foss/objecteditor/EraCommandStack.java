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
package era.foss.objecteditor;

import org.eclipse.emf.common.command.BasicCommandStack;

/**
 * A specialized CommandStack that allows to set a checkpoint and to rollback.
 * 
 */
public class EraCommandStack extends BasicCommandStack {

    /** The checkpoint. */
    protected int checkpoint;

    /**
     * Instantiates a new era command stack.
     * 
     * @since 10.03.2010
     */
    public EraCommandStack() {
        super();
        checkpoint = top;
    }

    /**
     * Planting a checkpoint for rollback simply remembers the current position of the CommandStack.
     * 
     * @since 10.03.2010
     */
    public void plantCheckpoint() {
        checkpoint = top;
    }

    /**
     * Perform undo operations until the planted position is reached.
     * 
     * @since 10.03.2010
     */
    public void rollback() {
        while (checkpoint < top) {
            assert (canUndo());
            undo();
        }
    }

    /**
     * Perform redo operations until the planted position is reached.
     * 
     * @category just4completeness
     * @since 10.03.2010
     */
    public void forwardreeling() {
        while ((top < checkpoint) && (checkpoint < (commandList.size() - 1))) {
            redo();
        }
    }

    /**
     * Inhibiting undos is like flushing. Additionally the need to save is enforced.
     * 
     * @since 10.03.2010
     */
    public void inhibitUndos() {
        super.flush();
        plantCheckpoint();
        // force the need to save
        super.saveIndex = -2;
    }

    /**
     * A specialized flush operation: flushing implicitly sets a checkpoint for rollback.
     * 
     * @see org.eclipse.emf.common.command.BasicCommandStack#flush()
     * @since 10.03.2010
     */
    public void flush() {
        super.flush();
        plantCheckpoint();
    }

    /**
     * A specialized saveIsDone: saving implicitly sets a checkpoint for rollback.
     * 
     * @see org.eclipse.emf.common.command.BasicCommandStack#saveIsDone()
     * @since 10.03.2010
     */
    public void saveIsDone() {
        super.saveIsDone();
        plantCheckpoint();
    }
}
