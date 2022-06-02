package ${package}.services;

import ${package}.entities.ItemEntity;
import ${package}.models.Item;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class ItemService {

    public List<Item> get() {
        List<ItemEntity> listAll = ItemEntity.findAll().list();
        return listAll.stream()
                .map(ie -> new Item(ie.getId(), ie.getName(), ie.getCount(), ie.getStatus()))
                .collect(Collectors.toList());
    }

    public Item get(String name) {
        Optional<ItemEntity> item = ItemEntity.find("item_name", name).firstResultOptional();
        return item.isPresent()
                ? new Item(item.get().getId(), item.get().getName(), item.get().getCount(), item.get().getStatus())
                : new Item();
    }

    @Transactional
    public Item create(Item item) {
        ItemEntity ie = new ItemEntity();
        ie.setName(item.getName());
        ie.setCount(item.getCount());
        ie.setStatus(item.getStatus());
        ie.persist();
        item.setId(ie.getId());
        return item;
    }

    @Transactional
    public Item update(Item item) {
        Optional<ItemEntity> optionalIe = ItemEntity.find("item_name", item.getName()).firstResultOptional();
        if (optionalIe.isEmpty()) {
            return new Item();
        }
        ItemEntity ie = optionalIe.get();
        if (item.getName() != null) {
            ie.setName(item.getName());
        }
        if (item.getCount() != null) {
            ie.setCount(item.getCount());
        }
        if (item.getStatus() != null) {
            ie.setStatus(item.getStatus());
        }
        item.setId(ie.getId());
        return item;
    }

    @Transactional
    public void delete(String name) {
        ItemEntity.delete("item_name", name);
    }
}
