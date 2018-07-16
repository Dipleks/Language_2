package update;

import db.TableDB;
import interfaceRoot.ArgumentsSettings;
import interfaceRoot.ArgumentsUpdate;

public interface IUpDate extends ArgumentsSettings, TableDB, ArgumentsUpdate
{
    void startUpDate(UpDate upDate);
}
