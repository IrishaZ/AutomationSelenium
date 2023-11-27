package enums;

public enum FirstDropdown {
    TITLE {
        @Override
        public String toString() {
            return "Title";
        }
    },
    ALBUM {
        @Override
        public String toString() {
            return "Album";
        }
    },
    ARTIST {
        @Override
        public String toString() {
            return "Artist";
        }
    },
    PLAYS,
    PLAYED, //last played
    LENGTH,
    ADDED, // date added
    MODIFIED, // date modified
}

