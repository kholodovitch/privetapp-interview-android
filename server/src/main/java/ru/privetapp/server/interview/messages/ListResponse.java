package ru.privetapp.server.interview.messages;

import ru.privetapp.server.interview.types.ListItems;

public class ListResponse implements IResponseData {
	private ListItems[] items;

	public ListItems[] getItems() {
		return items;
	}

	public void setItems(ListItems[] items) {
		this.items = items;
	}
}
