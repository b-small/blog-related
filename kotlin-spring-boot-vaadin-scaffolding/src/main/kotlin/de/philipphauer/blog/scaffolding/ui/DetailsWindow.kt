package de.philipphauer.blog.scaffolding.ui

import com.vaadin.server.FontAwesome
import com.vaadin.server.Sizeable
import com.vaadin.shared.ui.label.ContentMode
import com.vaadin.ui.Button
import com.vaadin.ui.FormLayout
import com.vaadin.ui.Label
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.Window

class DetailsWindow(snippet: SnippetOverviewItem) : Window(){
    init {
        caption = "Snippet Details"
        isModal = true
        val layout = FormLayout().apply {
            setMargin(true)
            isSpacing = true
            val codeLabel = Label().apply {
                contentMode = ContentMode.HTML
                caption = Labels.CODE
                value = snippet.code
                setWidth(100f, Sizeable.Unit.PERCENTAGE)
            }
            val stateLabel = Label().apply {
                contentMode = ContentMode.HTML
                caption = Labels.STATE
                value = "${snippet.state.toIcon().html} ${snippet.state.toLabel()}"
                setWidth(100f, Sizeable.Unit.PERCENTAGE)
            }
            val authorLabel = Label().apply {
                caption = Labels.AUTHOR
                value = snippet.author
                setWidth(100f, Sizeable.Unit.PERCENTAGE)
            }
            val closeButton = Button("Close", FontAwesome.CLOSE).apply {
                addClickListener { close() }
            }
            addComponents(codeLabel, authorLabel, stateLabel, closeButton)
            setWidth(100f, Sizeable.Unit.PERCENTAGE)
        }
        setWidth(50F, Sizeable.Unit.PERCENTAGE)
        setHeight(50F, Sizeable.Unit.PERCENTAGE)
        center()
        content = layout
    }
}
