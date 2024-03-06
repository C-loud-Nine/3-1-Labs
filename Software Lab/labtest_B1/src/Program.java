import java.util.Scanner;

public class Program {
    private Cache cache;
    private RAM ram;

    public Program(Cache cache, RAM ram) {
        this.cache = cache;
        this.ram = ram;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        int accessCount = 0;

        while (accessCount < 20) {
            System.out.print("Enter memory location to access: ");
            int memoryLocation = scanner.nextInt();

            // Check cache first
            Integer content = cache.getFromCache(memoryLocation);

            if (content == null) {
                // If not in cache, read from RAM and update cache
                content = ram.read(memoryLocation);
                cache.addToCache(memoryLocation, content);
            }

            System.out.println("Content at memory location " + memoryLocation + ": " + content);

            // Update access rate after 5 access instructions
            if (++accessCount % 5 == 0) {
                updateAccessRate();
            }
        }

        scanner.close();
    }

    private void updateAccessRate() {
        // Implement access rate update logic here
        // For simplicity, assume a random logic to update access rates
        System.out.println("Updating access rates...");
    }
}
