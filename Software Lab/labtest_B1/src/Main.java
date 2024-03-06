public class Main {
    public static void main(String[] args) {
        int numMemoryLocations = 10;
        int l1CacheSize = 1;
        int l2CacheSize = 2;

        RAM ram = new RAM(numMemoryLocations);
        Cache cache = new Cache(l1CacheSize, l2CacheSize);
        Program program = new Program(cache, ram);

        program.execute();
    }
}
