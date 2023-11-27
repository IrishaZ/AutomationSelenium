package enums;

public enum SecondDropdown {
    IS{
        @Override
        public String toString() {
            return "Is";
        }
    },
    IS_NOT{
        @Override
        public String toString() {
            return "is not";
        }
    },
    CONTAINS {
        @Override
        public String toString() {
            return "contains";
        }
    },
    DOES_NOT_CONTAINS {
        @Override
        public String toString() {
            return "does not contains";
        }
    },
    BEGIN, // begin with
    END_WITH //end with
}
