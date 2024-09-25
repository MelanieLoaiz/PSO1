
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos
 */
public class ContainerVm {
    /**
     * The size.
     */
    private long size;

    /**
     * The MIPS.
     */
    private double mips;

    /**
     * The number of PEs.
     */
    @SuppressWarnings("unused")
	private int numberOfPes;

    /**
     * The ram.
     */
    @SuppressWarnings("unused")
	private float ram;

    /**
     * The vmm.
     */
    private String vmm;

    /**
     * The host.
     */
    private ContainerHost host;

    /**
     * In migration flag.
     */
    private boolean inMigration;

    /**
     * The current allocated ram.
     */
    private float currentAllocatedRam;

    /**
     * The current allocated mips.
     */
    private List<Double> currentAllocatedMips;

    /**
     * The VM is being instantiated.
     */
    private boolean beingInstantiated;

    /**
     * The id.
     */
    private int id;

    /**
     * The storage.
     */
    private long storage;

    /**
     * The vm list.
     */
    private final List<? extends Container> containerList = new ArrayList<>();


    /**
     * Tells whether this machine is working properly or has failed.
     */
    private boolean failed;
}
