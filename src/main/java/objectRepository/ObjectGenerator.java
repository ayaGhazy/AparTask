package objectRepository;

import utilites.EnumClass;

public class ObjectGenerator extends ObjectRepositoryMapper{

    public ObjectGenerator(String fileName, String sheetName) {
        super(fileName, sheetName);

    }
    public ObjectGenerator()
    {
     super();

    }
    public ObjectElement generateObject(String objectName)
    {
        String findBy=getFindBy(objectName);
        String elementValue= getValue(objectName);
        ObjectElement objectElement= new ObjectElement(objectName
                , EnumClass.FindBy.valueOf(findBy)
               , elementValue);
        return objectElement;
    }
}
