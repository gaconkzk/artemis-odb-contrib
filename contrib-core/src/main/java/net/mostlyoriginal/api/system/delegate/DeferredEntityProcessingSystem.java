package net.mostlyoriginal.api.system.delegate;

import com.artemis.Aspect;
import com.artemis.BaseEntitySystem;
import com.artemis.World;

/**
 * Actor for a principal system.
 *
 * Deferred entity systems are a drop in replacement for
 * EntityProcessingSystem, where you need to delegate order of
 * entity processing to an overarching system.
 *
 * One example would be an animation, font and map rendering
 * subsystem of a simplistic render pipeline principal,
 * sorting render calls by z-layer.
 *
 * Upon entity insertion/removal, the system registers the entity
 * and itself with the principal. The principal can then register
 * and basic upon this information, and call begin/process(entity)/end
 * methods whenever desired.
 *
 * @author Daan van Yperen
 * @see net.mostlyoriginal.api.system.delegate.EntityProcessAgent
 * @see EntityProcessPrincipal
 */
public abstract class DeferredEntityProcessingSystem extends BaseEntitySystem {

    private final Aspect.Builder aspect;
    private final EntityProcessPrincipal principal;

    /**
     * Creates an entity system that uses the specified aspect as a matcher
     * against entities.
     *
     * @param aspect to match against entities
     * @param principal principal that will organize process calls to this system.
     */
    public DeferredEntityProcessingSystem(Aspect.Builder aspect, EntityProcessPrincipal principal) {
        super(aspect);
        this.aspect = aspect;
        this.principal = principal;
	// Set enable should not be called here
	// It should be called manually
        // setEnabled(false);
    }

    @Override
    protected void setWorld( World world ) {
	super.setWorld( world );

	setEnabled( false );
    }

    /**
   	 * Process a entity this system is interested in.
   	 *
   	 * @param e
   	 *			the entity to process
   	 */
   	protected abstract void process(int e);

    @Override
    protected void removed(int entityId) {

        // inform delegation handler
        principal.unregisterAgent(entityId, localProcessingAgent);

        super.removed(entityId);
    }

    @Override
    protected void inserted(int entityId) {
        super.inserted(entityId);

        // warn delegation handler we've lost interest in this entity.
        principal.registerAgent(entityId, localProcessingAgent);
    }

	@Override
	protected void processSystem() {
	}

	/**
     * Simple processing agent that delegates to this system.
     * Workaround for naming collisions, so the all callers
     * can use the methods they are used to.
     */
    protected EntityProcessAgent localProcessingAgent = new EntityProcessAgent() {
        @Override
        public void begin() {
            DeferredEntityProcessingSystem.this.begin();
        }

        @Override
        public void end() {
            DeferredEntityProcessingSystem.this.end();
        }

        @Override
        public void process(int e) {
            DeferredEntityProcessingSystem.this.process(e);
        }
    };
}
