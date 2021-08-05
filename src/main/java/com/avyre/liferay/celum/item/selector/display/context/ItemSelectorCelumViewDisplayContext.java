package com.avyre.liferay.celum.item.selector.display.context;

import com.avyre.liferay.celum.item.selector.ItemSelectorCelumView;
import com.liferay.item.selector.ItemSelectorReturnTypeResolver;
import com.liferay.item.selector.ItemSelectorReturnTypeResolverHandler;
import com.liferay.item.selector.criteria.image.criterion.ImageItemSelectorCriterion;
import com.liferay.portal.kernel.repository.model.FileEntry;
import java.util.Locale;

/**
 * @author Chris Whalen
 */
public class ItemSelectorCelumViewDisplayContext {

	public ItemSelectorCelumViewDisplayContext(
			ImageItemSelectorCriterion itemSelectorCriterion,
			ItemSelectorCelumView itemSelectorCelumView,
			String itemSelectedEventName,
			ItemSelectorReturnTypeResolverHandler
			itemSelectorReturnTypeResolverHandler) {

		_itemSelectorCriterion = itemSelectorCriterion;
		_itemSelectorCelumView = itemSelectorCelumView;
		_itemSelectedEventName = itemSelectedEventName;
		_itemSelectorReturnTypeResolverHandler = itemSelectorReturnTypeResolverHandler;
	}

//	public String[] getExtensions() {
//		return _itemSelectorCriterion.getExtensions();
//	}

	public String getItemSelectedEventName() {
		return _itemSelectedEventName;
	}

	public ItemSelectorReturnTypeResolver<?, ?>
		getItemSelectorReturnTypeResolver() {

		return _itemSelectorReturnTypeResolverHandler.getItemSelectorReturnTypeResolver(_itemSelectorCriterion, _itemSelectorCelumView,FileEntry.class);
	}

//	public long getMaxFileSize() {
//		return _itemSelectorCriterion.getMaxFileSize();
//	}

//	public String getNamespace() {
//		if (Validator.isNotNull(_itemSelectorCriterion.getPortletId())) {
//			return PortalUtil.getPortletNamespace(
//					_itemSelectorCriterion.getPortletId());
//		}
//
//		return StringPool.BLANK;
//	}

//	public String getRepositoryName() {
//		return _itemSelectorCriterion.getRepositoryName();
//	}

	public String getTitle(Locale locale) {
		return _itemSelectorCelumView.getTitle(locale);
	}

//	public String getURL() {
//		return _itemSelectorCriterion.getURL();
//	}

	private final String _itemSelectedEventName;
	private final ItemSelectorReturnTypeResolverHandler _itemSelectorReturnTypeResolverHandler;
	private final ItemSelectorCelumView _itemSelectorCelumView;
	private final ImageItemSelectorCriterion _itemSelectorCriterion;

}