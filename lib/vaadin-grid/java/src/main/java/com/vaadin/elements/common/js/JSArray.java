package com.vaadin.elements.common.js;

import java.util.List;

import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.query.client.js.JsUtils;

/**
 * This object represent a native JS Array of any JsType. In theory JsTypes are
 * JavaScriptObject but does not extend it so we need this.
 *
 * At the same time, we have a quick way to get a java List implementation so as
 * we can use easily this in foreach blocks.
 */
public class JSArray<T> extends JsArrayMixed {
    protected JSArray() {
    }

    public final void add(T value) {
        push(value);
    }

    public final void push(T value) {
        JsUtils.jsni(this, "push", value);
    }

    public final T get(int index) {
        return JsUtils.prop(this, index);
    }

    public final List<T> asList() {
        return JS.asList(this);
    }

    public final boolean isEmpty() {
        return length() == 0;
    }

    public final int size() {
        return length();
    }

    public final void add(T value, int index) {
        JsUtils.jsni(this, "splice", index, 0, value);
    }

    public final int indexOf(T value) {
        double val = JsUtils.jsni(this, "indexOf", value);
        return (int) val;
    }

    public final void remove(T value) {
        JsUtils.jsni(this, "splice", indexOf(value), 1);
    }
}
