package jp.co.drm.io.support;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DefaultPropertiesPersister;
import org.springframework.util.PropertiesPersister;

import jp.co.drm.util.LinkedProperties;

public class LinkedPropertiesLoaderSupport {
	/** Logger available to subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	private static final String XML_FILE_EXTENSION = ".xml";

	protected LinkedProperties[] localProperties;

	protected boolean localOverride = false;

	private Resource[] locations;

	private boolean ignoreResourceNotFound = false;

	private String fileEncoding;

	private PropertiesPersister propertiesPersister = new DefaultPropertiesPersister();

	/**
	 * Set local properties, e.g. via the "props" tag in XML bean definitions.
	 * These can be considered defaults, to be overridden by properties loaded
	 * from files.
	 */
	public void setProperties(LinkedProperties properties) {
		this.localProperties = new LinkedProperties[] { properties };
	}

	/**
	 * Set local properties, e.g. via the "props" tag in XML bean definitions,
	 * allowing for merging multiple properties sets into one.
	 */
	public void setPropertiesArray(LinkedProperties... propertiesArray) {
		this.localProperties = propertiesArray;
	}

	/**
	 * Set a location of a properties file to be loaded.
	 * <p>
	 * Can point to a classic properties file or to an XML file that follows JDK
	 * 1.5's properties XML format.
	 */
	public void setLocation(Resource location) {
		this.locations = new Resource[] { location };
	}

	/**
	 * Set locations of properties files to be loaded.
	 * <p>
	 * Can point to classic properties files or to XML files that follow JDK
	 * 1.5's properties XML format.
	 * <p>
	 * Note: Properties defined in later files will override properties defined
	 * earlier files, in case of overlapping keys. Hence, make sure that the
	 * most specific files are the last ones in the given list of locations.
	 */
	public void setLocations(Resource... locations) {
		this.locations = locations;
	}

	/**
	 * Set whether local properties override properties from files.
	 * <p>
	 * Default is "false": Properties from files override local defaults. Can be
	 * switched to "true" to let local properties override defaults from files.
	 */
	public void setLocalOverride(boolean localOverride) {
		this.localOverride = localOverride;
	}

	/**
	 * Set if failure to find the property resource should be ignored.
	 * <p>
	 * "true" is appropriate if the properties file is completely optional.
	 * Default is "false".
	 */
	public void setIgnoreResourceNotFound(boolean ignoreResourceNotFound) {
		this.ignoreResourceNotFound = ignoreResourceNotFound;
	}

	/**
	 * Set the encoding to use for parsing properties files.
	 * <p>
	 * Default is none, using the {@code java.util.Properties} default encoding.
	 * <p>
	 * Only applies to classic properties files, not to XML files.
	 *
	 * @see org.springframework.util.PropertiesPersister#load
	 */
	public void setFileEncoding(String encoding) {
		this.fileEncoding = encoding;
	}

	/**
	 * Set the PropertiesPersister to use for parsing properties files. The
	 * default is DefaultPropertiesPersister.
	 *
	 * @see org.springframework.util.DefaultPropertiesPersister
	 */
	public void setPropertiesPersister(PropertiesPersister propertiesPersister) {
		this.propertiesPersister = (propertiesPersister != null ? propertiesPersister
				: new DefaultPropertiesPersister());
	}

	/**
	 * Return a merged Properties instance containing both the loaded properties
	 * and properties set on this FactoryBean.
	 */
	protected Properties mergeProperties() throws IOException {
		Properties result = new LinkedProperties();

		if (this.localOverride) {
			// Load properties from file upfront, to let local properties
			// override.
			loadProperties(result);
		}

		if (this.localProperties != null) {
			for (Properties localProp : this.localProperties) {
				CollectionUtils.mergePropertiesIntoMap(localProp, result);
			}
		}

		if (!this.localOverride) {
			// Load properties from file afterwards, to let those properties
			// override.
			loadProperties(result);
		}

		return result;
	}

	/**
	 * Load properties into the given instance.
	 *
	 * @param props
	 *            the Properties instance to load into
	 * @throws IOException
	 *             in case of I/O errors
	 * @see #setLocations
	 */
	protected void loadProperties(Properties props) throws IOException {
		if (this.locations != null) {
			for (Resource location : this.locations) {
				if (logger.isDebugEnabled()) {
					logger.debug("Loading properties file from " + location);
				}
				try {
					fillProperties(props, new EncodedResource(location, this.fileEncoding), this.propertiesPersister);
				} catch (FileNotFoundException ex) {
					if (this.ignoreResourceNotFound) {
						if (logger.isInfoEnabled()) {
							logger.info("Properties resource not found: " + ex.getMessage());
						}
					} else {
						throw ex;
					}
				}
			}
		}
	}

	private void fillProperties(Properties props, EncodedResource resource, PropertiesPersister persister)
			throws IOException {

		InputStream stream = null;
		Reader reader = null;
		try {
			String filename = resource.getResource().getFilename();
			if (filename != null && filename.endsWith(XML_FILE_EXTENSION)) {
				stream = resource.getInputStream();
				persister.loadFromXml(props, stream);
			} else if (resource.requiresReader()) {
				reader = resource.getReader();
				persister.load(props, reader);
			} else {
				stream = resource.getInputStream();
				persister.load(props, stream);
			}
		} finally {
			if (stream != null) {
				stream.close();
			}
			if (reader != null) {
				reader.close();
			}
		}
	}

}