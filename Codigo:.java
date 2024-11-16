Codigo:

function updateList(items) {
    let list = document.getElementById("itemList");
    list.innerHTML = "";
    for (let i = 0; i < items.length; i++) {
      let listItem = document.createElement("li");
      listItem.innerHTML = items[i];
      list.appendChild(listItem);
    }
  }

  Que esta mal?

  al agregar elementos al DOM dentro del bucle es costoso, tambien cada iteración realiza operaciones separadas en el DOM.

  Se quedara asi el codigo.


Codigo:

public class ProductLoader {
    public List<Product> loadProducts() {
        List<Product> products = new ArrayList<>();
        for (int id = 1; id <= 100; id++) {
            products.add(database.getProductById(id));
        }
        return products;
    }
}

Que esta mal?
Obtener productos uno por uno genera múltiples llamadas a la base de datos ademas de itera a través de los IDs sin usar agrupación o precarga.

Se quedara asi el codigo.

public class ProductLoader {
    public List<Product> loadProducts() {
        return database.getProductsByIdRange(1, 100);
    }
}

Codigo:

public List<int> ProcessData(List<int> data) {
    List<int> result = new List<int>();
    foreach (var d in data) {
        if (d % 2 == 0) {
            result.Add(d * 2);
        } else {
            result.Add(d * 3);
        }
    }
    return result;
}

Que esta mal?

las validaciones repetidas (d % 2 == 0) en cada iteración esta mal ademas no seaprovecha el paralelismo para cálculos independientes.

Se quedara asi el codigo.

public List<int> ProcessData(List<int> data) {
    return data.AsParallel().Select(d => d % 2 == 0 ? d * 2 : d * 3).ToList();
}


