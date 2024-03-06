import java.util.HashMap;
import java.util.Map;

public class RAM {
    private Map<Integer, Integer> ram;

    public RAM(int numLocations) {
        this.ram = new HashMap<>();
        for (int i = 0; i < numLocations; i++) {
            ram.put(i, 0); // Initialize RAM with default values
        }
    }

    public int read(int memoryLocation) {
        return ram.getOrDefault(memoryLocation, -1);
    }

    public void write(int memoryLocation, int content) {
        ram.put(memoryLocation, content);
    }
}
