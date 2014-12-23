package org.dd4t.contentmodel.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.dd4t.contentmodel.Component;
import org.dd4t.contentmodel.ComponentPresentation;
import org.dd4t.contentmodel.ComponentTemplate;
import org.dd4t.core.databind.BaseViewModel;

import java.util.Hashtable;

/**
 * Class representing a component presentation which holds a component template and a component.
 *
 *  TODO: API changes!
 *
 * @author bjornl
 */
public class ComponentPresentationImpl implements ComponentPresentation {

    @JsonProperty("Component")
    @JsonDeserialize(as = ComponentImpl.class)
    private Component component;

    @JsonProperty("ComponentTemplate")
    @JsonDeserialize(as = ComponentTemplateImpl.class)
    private ComponentTemplate componentTemplate;

    @JsonProperty("IsDynamic")
    private boolean isDynamic;

    @JsonProperty("RenderedContent")
    private String renderedContent;

    @JsonProperty("OrderOnPage")
    private int orderOnPage;

    @JsonIgnore
    private Hashtable<String,BaseViewModel> baseViewModels;

    /**
     * Get the component
     *
     * @return the component
     */
    public Component getComponent() {
        return component;
    }

    /**
     * Set the component
     *
     * @param component
     */
    public void setComponent(Component component) {
        this.component = component;
    }

    /**
     * Get the component template
     *
     * @return the component template
     */
    public ComponentTemplate getComponentTemplate() {
        return componentTemplate;
    }

    /**
     * Set the component template
     *
     * @param componentTemplate
     */
    public void setComponentTemplate(ComponentTemplate componentTemplate) {
        this.componentTemplate = componentTemplate;
    }

    public String getRenderedContent() {
        return renderedContent;
    }

    public void setRenderedContent(String renderedContent) {
        this.renderedContent = renderedContent;
    }

    @Override
    public boolean isDynamic() {
        return isDynamic;
    }

    public void setIsDynamic(final boolean isDynamic) {
        this.isDynamic = isDynamic;
    }

    public int getOrderOnPage() {
        return orderOnPage;
    }

    public void setOrderOnPage(final int orderOnPage) {
        this.orderOnPage = orderOnPage;
    }

    @Override public Hashtable<String, BaseViewModel> getAllViewModels () {
        if (this.baseViewModels == null) {
            return new Hashtable<>();
        }
        return this.baseViewModels;
    }

    @Override public void setViewModel (final Hashtable<String, BaseViewModel> models) {
        this.baseViewModels = models;
    }

    @Override public BaseViewModel getViewModel (String key) {
        if (this.baseViewModels != null && this.baseViewModels.containsKey(key)) {
            return this.baseViewModels.get(key);
        }
        return null;
    }
}