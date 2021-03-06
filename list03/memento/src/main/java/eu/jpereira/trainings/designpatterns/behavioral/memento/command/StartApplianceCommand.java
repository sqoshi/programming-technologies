/**
 * Copyright 2011 Joao Miguel Pereira
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package eu.jpereira.trainings.designpatterns.behavioral.memento.command;

import eu.jpereira.trainings.designpatterns.behavioral.memento.appliance.Appliance;
import eu.jpereira.trainings.designpatterns.behavioral.memento.appliance.ApplianceCommunicationException;

/**
 * @author jpereira
 * 
 */
public class StartApplianceCommand extends AbstractCommand {

	/**
	 * @param appliance
	 */
	public StartApplianceCommand(Appliance appliance) {
		super(appliance);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.behavioral.mediator.command.Command
	 * #execute()
	 */
	@Override
	public void execute() throws CouldNotExecuteCommandException {
		try {
			this.receiverAppliance.start();
		} catch (ApplianceCommunicationException e) {
			// Log it
			e.printStackTrace();
			// encapsulate exception
			throw new CouldNotExecuteCommandException(e.fillInStackTrace());
		}

	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.mediator.command.UndoableCommand#rollback()
	 */
	@Override
	public void rollback() throws CouldNotRollbackCommandException {
		
		try {
			this.receiverAppliance.stop();
		} catch (ApplianceCommunicationException e) {
			// Log it
			e.printStackTrace();
			throw new CouldNotRollbackCommandException(e.fillInStackTrace());
		}
		
		
	}

}
