package jp.co.drm.beans.factory.config;

import java.util.Properties;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import jp.co.drm.io.support.LinkedPropertiesLoaderSupport;

/**
 * Allows for making a properties file from a classpath location available as
 * Properties instance in a bean factory. Can be used to populate any bean
 * property of type Properties via a bean reference.
 *
 * <p>
 * Supports loading from a properties file and/or setting local properties on
 * this FactoryBean. The created Properties instance will be merged from loaded
 * and local values. If neither a location nor local properties are set, an
 * exception will be thrown on initialization.
 *
 * <p>
 * Can create a singleton or a new object on each request. Default is a
 * singleton.
 *
 * @author Juergen Hoeller
 * @see #setLocation
 * @see #setProperties
 * @see #setLocalOverride
 * @see java.util.Properties
 */
public class LinkedPropertiesFactoryBean extends LinkedPropertiesLoaderSupport
		implements FactoryBean<Properties>, InitializingBean {

	private boolean singleton = true;

	private Properties singletonInstance;

	/**
	 * Set whether a shared 'singleton' Properties instance should be created,
	 * or rather a new Properties instance on each request.
	 * <p>
	 * Default is "true" (a shared singleton).
	 */
	public final void setSingleton(boolean singleton) {
		this.singleton = singleton;
	}

	@Override
	public final boolean isSingleton() {
		return this.singleton;
	}

	@Override
	public final void afterPropertiesSet() throws Exception {
		if (this.singleton) {
			this.singletonInstance = createProperties();
		}
	}

	@Override
	public final Properties getObject() throws Exception {
		if (this.singleton) {
			return this.singletonInstance;
		} else {
			return createProperties();
		}
	}

	@Override
	public Class<Properties> getObjectType() {
		return Properties.class;
	}

	/**
	 * Template method that subclasses may override to construct the object
	 * returned by this factory. The default implementation returns the plain
	 * merged Properties instance.
	 * <p>
	 * Invoked on initialization of this FactoryBean in case of a shared
	 * singleton; else, on each {@link #getObject()} call.
	 *
	 * @return the object returned by this factory
	 * @throws Exception
	 * @see #mergeProperties()
	 */
	protected Properties createProperties() throws Exception {
		return mergeProperties();
	}

}
