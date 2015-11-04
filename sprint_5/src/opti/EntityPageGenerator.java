package opti;

import java.util.*;

public abstract class EntityPageGenerator implements PageGenerator {
    protected Map<String, String> csvPaths;

    public EntityPageGenerator(HashMap<String, String> csvPaths) {
        this.csvPaths = Collections.unmodifiableMap(csvPaths);
    }
}
