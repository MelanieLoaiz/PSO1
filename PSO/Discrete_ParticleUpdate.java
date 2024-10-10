import java.util.*;

/**
 * Particle update strategy
 * 
 * Every Swarm.evolve() itereation the following methods are called
 * 		- begin(Swarm) : Once at the begining of each iteration
 * 		- update(Swarm,Particle) : Once for each particle
 * 		- end(Swarm) : Once at the end of each iteration
 * 
 * @author carlosandres.mendez
 */
public class Discrete_ParticleUpdate {

    Discrete_PSO_Swarm swarm;

    //A random weight r1.
    private final double WEIGHT_R1 = 0.2d;
    //The cognitive acceleration coefficient c1.
    private final double COGNIT_COEFFICIENT = 0.5d;

    //A random weight r2.
    private final double WEIGHT_R2 = 0.2d;
    //The social coefficient
    private final double SOCIAL_COEFFICIENT = 0.5d;

    
    public Discrete_ParticleUpdate() {
    }

    /** Update particle's velocity and position */
    public void update(Discrete_PSO_Swarm swarm, Discrete_Particle particle) {
        this.swarm = swarm;
        
        //realizar una modificacion aleatoria
        List<Allocation> position = particle.getPosition();
        ContainerVm vm = null;
        int cont = 0;
        for(Allocation asignacion : position){
            Random random = new Random();
            int randomNumber = random.nextInt(swarm.getVms().size());
            vm = swarm.getVms().get(randomNumber);
            asignacion.setVm(vm); //IMPORANTE> modificando la POSICION/configuracion/asignacion recursos
            
            
            //buscar si la vm que estamos asignando existe en la posicion
            boolean vmExiste = false;
            for(Allocation allocation : position){
                if(vm.getId()==allocation.getVm().getId()){
                    vmExiste = true;
                    break;
                }
            }

            if(!vmExiste){
                random = new Random();
                randomNumber = random.nextInt(swarm.getHosts().size());
                ContainerHost host = swarm.getHosts().get(randomNumber);
                asignacion.setHost(host);
            }
            
            cont++;
            if(cont>1)
                break;
        }


        //acomodar los contenedores en la menor cantidad de mv o las menos costosas
        

    }



}
