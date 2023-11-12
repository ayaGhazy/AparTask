package objectRepository;
import utilites.EnumClass;

public class ObjectElement {
    String objectElement;
    EnumClass.FindBy findBy;
    String value;

    public ObjectElement(String objectElement, EnumClass.FindBy findBy, String value) {
        this.objectElement = objectElement;
        this.findBy = findBy;
        this.value = value;
    }

    public String getObjectElement() {
        return objectElement;
    }

    public EnumClass.FindBy getFindBy() {
        return findBy;
    }

    public String getValue() {
        return value;
    }
}
