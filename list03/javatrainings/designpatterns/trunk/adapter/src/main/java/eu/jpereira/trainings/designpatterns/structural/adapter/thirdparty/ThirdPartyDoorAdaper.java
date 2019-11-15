package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;

import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotUnlockDoorException;

import static eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.ThirdPartyDoor.LockStatus.UNLOCKED;

public class ThirdPartyDoorAdaper extends ThirdPartyDoor implements Door {
    ThirdPartyDoor thirdPartyDoor = new ThirdPartyDoor();

    @Override
    public void open(String code) throws IncorrectDoorCodeException {
        try {
            thirdPartyDoor.unlock(code);
        } catch (CannotUnlockDoorException e) {
                throw new IncorrectDoorCodeException();
        }
    }

    @Override
    public void close() {
        thirdPartyDoor.lock();
    }

    @Override
    public boolean isOpen() {
        return thirdPartyDoor.getLockStatus().equals(UNLOCKED);
    }

    @Override
    public void changeCode(String oldCode, String newCode, String newCodeConfirmation) throws IncorrectDoorCodeException, CodeMismatchException {
        if (newCode.equals(newCodeConfirmation)) {
            if (oldCode.equals(thirdPartyDoor.code)) {
                thirdPartyDoor.code = newCode;
            } else {
                throw new IncorrectDoorCodeException();
            }
        } else {
            throw new CodeMismatchException();
        }
    }

    @Override
    public boolean testCode(String code) {
        return code.equals(thirdPartyDoor.code);
    }
}

