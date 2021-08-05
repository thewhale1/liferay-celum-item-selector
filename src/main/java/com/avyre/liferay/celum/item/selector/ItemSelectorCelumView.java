package com.avyre.liferay.celum.item.selector;

import com.avyre.liferay.celum.item.selector.display.context.ItemSelectorCelumViewDisplayContext;
import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.ItemSelectorReturnTypeResolverHandler;
import com.liferay.item.selector.ItemSelectorView;
import com.liferay.item.selector.criteria.DownloadFileEntryItemSelectorReturnType;
import com.liferay.item.selector.criteria.DownloadURLItemSelectorReturnType;
import com.liferay.item.selector.criteria.FileEntryItemSelectorReturnType;
import com.liferay.item.selector.criteria.URLItemSelectorReturnType;
import com.liferay.item.selector.criteria.image.criterion.ImageItemSelectorCriterion;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.util.ListUtil;

import java.io.IOException;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Chris Whalen
 */
@Component(
	property = "item.selector.view.order:Integer=200",
	service = ItemSelectorView.class
)
public class ItemSelectorCelumView implements ItemSelectorView<ImageItemSelectorCriterion> {

	@Override
	public Class<? extends ImageItemSelectorCriterion> getItemSelectorCriterionClass() {
		return ImageItemSelectorCriterion.class;
	}

	public ServletContext getServletContext() {
		return _servletContext;
	}

	@Override
	public List<ItemSelectorReturnType> getSupportedItemSelectorReturnTypes() {
		return _supportedItemSelectorReturnTypes; 
	}

	@Override
	public String getTitle(Locale locale) {
		return _language.get(locale, "celum-image-item-selector-view");
	}

	@Override
	public void renderHTML( 
			ServletRequest servletRequest, 
			ServletResponse servletResponse,
			ImageItemSelectorCriterion itemSelectorCriterion,
			PortletURL portletURL, 
			String itemSelectedEventName, 
			boolean search)
		throws IOException, ServletException {
		
		ServletContext servletContext = getServletContext(); 
		
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/view.jsp");
		
		ItemSelectorCelumViewDisplayContext itemSelectorCelumViewDisplayContext = new ItemSelectorCelumViewDisplayContext(
				itemSelectorCriterion, 
				this, 
				itemSelectedEventName,
				_itemSelectorReturnTypeResolverHandler);

		servletRequest.setAttribute(ITEM_SELECTOR_CELUM_VIEW_DISPLAY_CONTEXT, itemSelectorCelumViewDisplayContext);
		
		requestDispatcher.include(servletRequest, servletResponse);
	}

	@Reference(
		target = "(osgi.web.symbolicname=com.avyre.liferay.celum.item.selector)",
		unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	private static final List<ItemSelectorReturnType> _supportedItemSelectorReturnTypes = Collections.unmodifiableList(
			ListUtil.fromArray(
					new DownloadFileEntryItemSelectorReturnType(),
					new DownloadURLItemSelectorReturnType(),
					new FileEntryItemSelectorReturnType(),
					new URLItemSelectorReturnType()
			));

	@Reference
	private Language _language;
	
	@Reference
	private ItemSelectorReturnTypeResolverHandler _itemSelectorReturnTypeResolverHandler;

	private ServletContext _servletContext;
	
	public static String ITEM_SELECTOR_CELUM_VIEW_DISPLAY_CONTEXT = "ITEM_SELECTOR_CELUM_VIEW_DISPLAY_CONTEXT";
}