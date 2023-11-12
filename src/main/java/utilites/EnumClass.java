package utilites;

public class EnumClass {
    public enum FindBy {
        id("id"),
        name("name"),
        xpath("xpath"),
        css("cssSelector"),
        className("className")
        ,partialLinkText("partialLinkText")

        ;
        private final String value;

        FindBy(String value) {
            this.value = value;
        }
        public String getValue() {
            return this.value;
        }
    }

    public enum ObjectElement
    {
        findBy,
        value
    }
    public enum webBrowser {
        ch("chrome"),
        ff("firefox");
        private final String value;

        webBrowser(String value) {
            this.value = value;
        }
        public String getValue() {
            return this.value;
        }

        public static int fromInteger(webBrowser x) {
            switch (x) {
                case ch:
                    return 0;
                case ff:
                    return 1;
            }
            return 1;
        }
    }
    public enum sleepMode {Min, HOURS, Mill,Sec}

    public enum ObjectRepository
    {
        elementName("Element Name"),
        findBy("Find By"),
        value("Value"),
        page("Page");
        private final String elementValue;

        ObjectRepository(String elementValue) {
            this.elementValue = elementValue;
        }

        public String getElementValue() {
            return this.elementValue;
        }
    }
}
