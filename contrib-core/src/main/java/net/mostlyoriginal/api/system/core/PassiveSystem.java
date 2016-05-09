package net.mostlyoriginal.api.system.core;

import com.artemis.BaseSystem;
import com.artemis.World;

/**
 * Headless system.
 *
 * For tickless secondary systems that service primary systems.
 *
 * @author Daan van Yperen
 */
public class PassiveSystem extends BaseSystem {

    public PassiveSystem() {
        // Now we can't set enable at constructor
        // setEnabled(false);
    }

    @Override
    protected void setWorld( World world ) {
        super.setWorld( world );

        setEnabled( false );
    }

    @Override
    protected void processSystem() {
	    // do nothing!
    }
}
