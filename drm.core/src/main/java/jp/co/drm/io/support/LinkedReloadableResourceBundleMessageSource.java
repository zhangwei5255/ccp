package jp.co.drm.io.support;

import java.util.Properties;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import jp.co.drm.util.LinkedProperties;

public class LinkedReloadableResourceBundleMessageSource extends ReloadableResourceBundleMessageSource {

	@Override
	protected Properties newProperties() {
		return new LinkedProperties();
	}
}
