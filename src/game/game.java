package game;

import game.display.display;

public class game implements Runnable{

    public int width, height;
    public String title;
    private Thread thread;
    private boolean running = false;

    public game(String title, int width, int height) {
        this.height = height;
        this.width = width;
        this.title = title;
    }
    private  void init(){
        new display(title, width, height);
    }

    private void tick(){

    }
    private void render(){

    }

    public void run() {
        init();

        while (running){
            tick();
            render();
        }

        stop();
    }
    public synchronized void start(){
        if (running){
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop(){
        if (!running){
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
