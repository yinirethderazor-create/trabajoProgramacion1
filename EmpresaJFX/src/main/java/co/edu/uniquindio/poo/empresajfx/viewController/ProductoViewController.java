package co.edu.uniquindio.poo.empresajfx.viewController;

import co.edu.uniquindio.poo.empresajfx.App;
import co.edu.uniquindio.poo.empresajfx.controller.ProductoController;
import co.edu.uniquindio.poo.empresajfx.model.Producto;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ProductoViewController {

    private ProductoController productoController;
    private ObservableList<Producto> listProductos = FXCollections.observableArrayList();
    private Producto selectedProducto;
    private App app;

    @FXML private TextField txtCodigo;
    @FXML private TextField txtNombre;
    @FXML private TextField txtPrecio;

    @FXML private TableView<Producto> tblListProducto;
    @FXML private TableColumn<Producto, String> tbcCodigo;
    @FXML private TableColumn<Producto, String> tbcNombre;
    @FXML private TableColumn<Producto, Double> tbcPrecio;

    @FXML private Button btnAgregarProducto;
    @FXML private Button btnActualizarProducto;
    @FXML private Button btnLimpiar;
    @FXML private Button btnEliminar;

    @FXML
    void onAgregarProducto() {
        agregarProducto();
    }

    @FXML
    void onActualizarProducto() {
        actualizarProducto();
    }

    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }

    @FXML
    void onEliminar() {
        eliminarProducto();
    }

    public void setApp(App app) {
        this.app = app;
        this.productoController = new ProductoController(App.empresa);
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerProductos();
        tblListProducto.getItems().clear();
        tblListProducto.setItems(listProductos);
        listenerSelection();
    }

    private void initDataBinding() {
        tbcCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigo()));
        tbcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcPrecio.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPrecio()));
    }

    private void obtenerProductos() {
        listProductos.addAll(productoController.obtenerListaProductos());
    }

    private void listenerSelection() {
        tblListProducto.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedProducto = newSelection;
            mostrarInformacionProducto(selectedProducto);
        });
    }

    private void mostrarInformacionProducto(Producto producto) {
        if (producto != null) {
            txtCodigo.setText(producto.getCodigo());
            txtNombre.setText(producto.getNombre());
            txtPrecio.setText(String.valueOf(producto.getPrecio()));
        }
    }

    private void agregarProducto() {
        Producto producto = buildProducto();
        if (producto != null && productoController.crearProducto(producto)) {
            listProductos.add(producto);
            limpiarCamposProducto();
        }
    }

    private Producto buildProducto() {
        try {
            double precio = Double.parseDouble(txtPrecio.getText());
            return new Producto(txtCodigo.getText(), txtNombre.getText(), precio);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private void eliminarProducto() {
        if (selectedProducto != null && productoController.eliminarProducto(txtCodigo.getText())) {
            listProductos.remove(selectedProducto);
            limpiarCamposProducto();
            limpiarSeleccion();
        }
    }

    private void actualizarProducto() {
        if (selectedProducto != null) {
            Producto actualizado = buildProducto();
            if (actualizado != null && productoController.actualizarProducto(selectedProducto.getCodigo(), actualizado)) {
                int index = listProductos.indexOf(selectedProducto);
                if (index >= 0) {
                    listProductos.set(index, actualizado);
                }
                tblListProducto.refresh();
                limpiarSeleccion();
                limpiarCamposProducto();
            }
        }
    }

    private void limpiarSeleccion() {
        tblListProducto.getSelectionModel().clearSelection();
        limpiarCamposProducto();
    }

    private void limpiarCamposProducto() {
        txtCodigo.clear();
        txtNombre.clear();
        txtPrecio.clear();
    }
}
