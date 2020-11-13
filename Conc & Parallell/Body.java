import java.util.concurrent.ThreadLocalRandom;

public class Body {
    static final double grav = 0.000000000066743;

    double mass;

    double x;
    double y;

    double velX;
    double velY;

    double timeInterval;

    Body(double mass, double initX, double initY, double initVelX, double initVelY, double deltaT){
        this.mass = mass;
        this.x = initX;
        this.y = initY;
        this.velX = initVelX;
        this.y = initVelY;
        this.timeInterval = deltaT;
    }

    Force attraction(Body other){
        return new Force(this, other);
    }

    Force netAttraction(Body[] others){
        Force total = new Force(0,0);
        for(Body x : others){
            total = total.add(new Force(this, x));
        }

        return total;
    }

    void UpdateVelocity(Force f){
        double xAcceleration = f.x / mass;
        double yAcceleration = f.y / mass;

        velX = xAcceleration * timeInterval;
        velY = yAcceleration * timeInterval;
    }

    void UpdatePosition(){
        x = x + velX * timeInterval;
        y = y + velY * timeInterval;
    }

    double distance(Body other){
        return Math.sqrt(Math.pow((other.x - this.x), 2) + Math.pow((other.y - this.y), 2));
    }

    public static void main(String[] args) throws InterruptedException {
        final int xMin = -10;
        final int xMax = 10;
        final int yMin = -10;
        final int yMax = 10;

        final int massMin = 1;
        final int massMax = 5;

        final double velXMin = 0;
        final double velXMax = 5;
        final double velYMin = 0;
        final double velYMax = 5;
        
        final double deltaT = .5;

        int numBodies = 10;
        Body[] bodies = new Body[numBodies];

        ThreadLocalRandom random = ThreadLocalRandom.current();

        for(int i = 0; i < numBodies; i++){
            bodies[i] = new Body(
                random.nextDouble(massMin, massMax), 
                random.nextDouble(xMin, xMax), random.nextDouble(yMin, yMax), 
                random.nextDouble(velXMin, velXMax), random.nextDouble(velYMin, velYMax), 
                deltaT
            );
        }

        while(true){
            generatePicture(bodies);

            for(Body x : bodies){
                Force netForce = x.netAttraction(bodies);
                x.UpdateVelocity(netForce);
            }

            for(Body x : bodies){
                x.UpdatePosition();
            }

            Thread.sleep(((long)deltaT * 2000));
        }
    }

    static void generatePicture(Body[] bodies){
        //TODO: Implement picture generation
    }

    class Force{
        double x;
        double y;

        Force(Body a, Body b){
            double gravForce = grav * (a.mass * b.mass) / Math.pow(a.distance(b), 2);

            double xDir = b.x - a.x;
            double yDir = b.y - a.y;

            double magnitude = Math.sqrt(Math.pow(xDir, 2) + Math.pow(yDir, 2));

            x = (xDir / magnitude) * gravForce;
            y = (yDir / magnitude) * gravForce;
        }

        Force(double x, double y){
            this.x = x;
            this.y = y;
        }

        Force add(Force other){
            return new Force(this.x + other.x, this.y + other.y);
        }
    }
}
