package com.example;

import com.example.views.*;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;

public class MainLayout extends AppLayout {

    public MainLayout() {
        H1 title = new H1("Clipboard API Demos");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "var(--lumo-space-m)");

        addToNavbar(new DrawerToggle(), title);

        SideNav nav = new SideNav();

        nav.addItem(new SideNavItem("1. Copy static text",
                CopyStaticTextView.class));
        nav.addItem(new SideNavItem("2. Copy from component",
                CopyFromComponentView.class));
        nav.addItem(new SideNavItem("3. Update text to copy",
                UpdateTextToCopyView.class));
        nav.addItem(new SideNavItem("4. Copy server-computed",
                CopyServerComputedView.class));
        nav.addItem(new SideNavItem("5. Read clipboard text",
                ReadClipboardTextView.class));
        nav.addItem(new SideNavItem("6. Copy image",
                CopyImageView.class));
        nav.addItem(new SideNavItem("7. Copy image component",
                CopyImageComponentView.class));
        nav.addItem(new SideNavItem("8. Paste text",
                PasteTextView.class));
        nav.addItem(new SideNavItem("9. Paste HTML",
                PasteHtmlView.class));
        nav.addItem(new SideNavItem("10. Paste images",
                PasteImagesView.class));
        nav.addItem(new SideNavItem("11. Paste files",
                PasteFilesView.class));
        nav.addItem(new SideNavItem("12. Copy/cut events",
                CopyCutEventsView.class));

        addToDrawer(new Scroller(nav));
    }
}
