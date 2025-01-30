package GameLoop;

public class FPSController {
    private final int targetFPS;
    private final int frameTime;

    public FPSController(int targetFPS) {
        this.targetFPS = targetFPS;
        this.frameTime = 1000 / targetFPS;
    }

    public void run(GameLoop gameLoop) {
        long previousTime = System.currentTimeMillis();

        while (true) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - previousTime;

            if (elapsedTime >= frameTime) {
                previousTime = currentTime;
                gameLoop.update();
                gameLoop.render();
            } else {
                try {
                    Thread.sleep(frameTime - elapsedTime); // Sleep to maintain FPS
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
}
