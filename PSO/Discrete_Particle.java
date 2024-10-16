import java.util.*;

/**
 * 
 * @author carlosandres.mendez
 */
public class Discrete_Particle {

    /** Best fitness function so far */
    double bestFitness;
    /** Best particles's position so far */
    List<Allocation> bestPosition;
    /** current fitness */
    double fitness;
    /** Position */
    List<Allocation> position;
    /** Velocity */
    List<Allocation> velocity;

    //-------------------------------------------------------------------------
    // Constructors
    //-------------------------------------------------------------------------

    import numpy as np

    /**Parámetros del PSO*/
w = 0.5  # Coeficiente de inercia
c1 = 1.5  # Coeficiente cognitivo
c2 = 1.5  # Coeficiente social
num_particles = 2
num_iterations = 10

/**Inicialización del enjambre*/
particles = np.random.rand(num_particles, 2)  /** Posiciones iniciales*/
velocities = np.zeros((num_particles, 2))  /** Velocidades iniciales*/
personal_best_positions = particles.copy()
personal_best_scores = np.full(num_particles, np.inf)
global_best_position = None
global_best_score = np.inf

/**Función objetivo (ejemplo)*/
def objective_function(x):
    return np.sum(x**2)

**/PSO loop*/
for iteration in range(num_iterations):
    for i in range(num_particles):
        score = objective_function(particles[i])
        if score < personal_best_scores[i]:
            personal_best_scores[i] = score
            personal_best_positions[i] = particles[i]
        if score < global_best_score:
            global_best_score = score
            global_best_position = particles[i]
    
    for i in range(num_particles):
        r1, r2 = np.random.rand(2)
        velocities[i] = (w * velocities[i] +
                         c1 * r1 * (personal_best_positions[i] - particles[i]) +
                         c2 * r2 * (global_best_position - particles[i]))
        particles[i] += velocities[i]

print("Mejor posición encontrada:", global_best_position)
print("Mejor puntuación:", global_best_score)

    /**
     * Constructor 
     */
    public Discrete_Particle() {
        position = new ArrayList<>();
        bestPosition = new ArrayList<>();
        velocity = new ArrayList<>();
        bestFitness = Double.NaN;
        fitness = Double.NaN;
    }

    

    //-------------------------------------------------------------------------
    // Methods
    //-------------------------------------------------------------------------

    public Discrete_Particle(List<Allocation> position, List<Allocation> velocity) {
        this.position = position;
        this.velocity = velocity;
    }



    /** Copy position[] to positionCopy[] */
    public void copyPosition(List<Allocation> positionCopy) {
        positionCopy.clear();
        for(Allocation alloc : position)
            positionCopy.add(new Allocation(alloc.getContainer(), alloc.getVm(), alloc.getHost()));
    }

    /** Copy position[] to bestPosition[] */
    public void copyPosition2Best() {
        bestPosition = new ArrayList<>();
        for(Allocation alloc : position)
            bestPosition.add(new Allocation(alloc.getContainer(), alloc.getVm(), alloc.getHost()));
    }

    public double getBestFitness() {
        return bestFitness;
    }

    public List<Allocation> getBestPosition() {
        return bestPosition;
    }

    public int getDimension() {
        return position.size();
    }

    public double getFitness() {
        return fitness;
    }

    public List<Allocation> getPosition() {
        return position;
    }

    public List<Allocation> getVelocity() {
        return velocity;
    }

    public void setBestFitness(double bestFitness) {
        this.bestFitness = bestFitness;
    }

    public void setBestPosition(List<Allocation> bestPosition) {
        this.bestPosition = bestPosition;
    }

    /**
     * Set fitness and best fitness accordingly.
     * If it's the best fitness so far, copy data to bestFitness[]
     * @param fitness : New fitness value
     * @param maximize : Are we maximizing or minimizing fitness function?
     */
    public void setFitness(double fitness, boolean maximize) {
        this.fitness = fitness;
        if ((maximize && (fitness > bestFitness)) // Maximize and bigger? => store data
                || (!maximize && (fitness < bestFitness)) // Minimize and smaller? => store data too
                || Double.isNaN(bestFitness)) {
            copyPosition2Best();
            bestFitness = fitness;
        }
    }

    public void setPosition(List<Allocation> position) {
        this.position = position;
    }

    public void setVelocity(List<Allocation> velocity) {
        this.velocity = velocity;
    }

    /** Printable string */
    @Override
    public String toString() {
        String str = "fitness: " + fitness + "\tbest fitness: " + bestFitness;

        if (position != null) {
            str += "\n\tPosition:\t";
            for (Allocation allocation : position)
                str += allocation + "\t";
        }

        if (velocity != null) {
            str += "\n\tVelocity:\t";
            for (Allocation allocation : velocity)
                str += allocation + "\t";
        }

        if (bestPosition != null) {
            str += "\n\tBest:\t";
            for (Allocation allocation : bestPosition)
                str += allocation + "\t";
        }

        str += "\n";
        return str;
    }
}

