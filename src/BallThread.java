class BallThread extends Thread {
    private Ball b;
    private int speed;

    BallThread(Ball ball){
        b = ball;
        speed = 5;
    }

    void boost() {
        speed -= 1;
    }

    void loss() {
        speed += 1;
    }

    void grow() { b.sizeUp(); }

    void decrease() { b.sizeDown(); }


    @Override
    public void run(){
        try {
            for (int i = 1; i < 10000; i++){
                if (!b.move())
                    break;

                System.out.println("Thread name = "
                        + Thread.currentThread().getName());
                Thread.sleep(speed);

            }
        } catch(InterruptedException ignored) { }
    }
}