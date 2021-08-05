package com.avyre.liferay.celum.item.selector.criterion;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import com.liferay.item.selector.BaseItemSelectorCriterionHandler;
import com.liferay.item.selector.ItemSelectorCriterionHandler;

@Component(service = ItemSelectorCriterionHandler.class)
public class CelumItemSelectorCriterionHandler extends BaseItemSelectorCriterionHandler<CelumItemSelectorCriterion> {

    public Class <CelumItemSelectorCriterion> 
    getItemSelectorCriterionClass() {
        return CelumItemSelectorCriterion.class;
    }

    @Activate
    @Override
    protected void activate(BundleContext bundleContext) {
            super.activate(bundleContext);
    }

}
