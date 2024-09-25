
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carlos
 */
public class ContainerHost {
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
    private final List<? extends ContainerVm> vmList = new ArrayList<>();
}
