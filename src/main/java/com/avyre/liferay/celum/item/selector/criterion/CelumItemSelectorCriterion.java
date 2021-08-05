package com.avyre.liferay.celum.item.selector.criterion;

import com.liferay.item.selector.BaseItemSelectorCriterion;
import com.liferay.item.selector.criteria.image.criterion.ImageItemSelectorCriterion;
import com.liferay.portal.kernel.upload.UploadServletRequestConfigurationHelperUtil;

/**
 * @author Chris Whalen
 */
public class CelumItemSelectorCriterion extends BaseItemSelectorCriterion {

	public CelumItemSelectorCriterion() {
		super();
	}

	public CelumItemSelectorCriterion(String portletId, String url, String repositoryName) {

		this(portletId, url, repositoryName, UploadServletRequestConfigurationHelperUtil.getMaxSize());
	}

	public CelumItemSelectorCriterion(String portletId, String url, String repositoryName, long maxFileSize) 
	{
		super();
		_portletId = portletId;
		_url = url;
		_repositoryName = repositoryName;
		_maxFileSize = maxFileSize;
	}

	public CelumItemSelectorCriterion(String portletId, String url, String repositoryName, long maxFileSize, String[] extensions) 
	{
		super();
		_portletId = portletId;
		_url = url;
		_repositoryName = repositoryName;
		_maxFileSize = maxFileSize;
		_extensions = extensions;
	}

	public String[] getExtensions() {
		return _extensions;
	}

	public long getMaxFileSize() {
		return _maxFileSize;
	}

	public String getPortletId() {
		return _portletId;
	}

	public String getRepositoryName() {
		return _repositoryName;
	}

	public String getURL() {
		return _url;
	}

	public void setExtensions(String[] extensions) {
		_extensions = extensions;
	}

	public void setMaxFileSize(long maxFileSize) {
		_maxFileSize = maxFileSize;
	}

	public void setPortletId(String portletId) {
		_portletId = portletId;
	}

	public void setRepositoryName(String repositoryName) {
		_repositoryName = repositoryName;
	}

	public void setURL(String url) {
		_url = url;
	}

	private String[] _extensions;
	private long _maxFileSize;
	private String _portletId;
	private String _repositoryName;
	private String _url;

}