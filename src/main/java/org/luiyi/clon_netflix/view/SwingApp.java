package org.luiyi.clon_netflix.view;

import org.luiyi.clon_netflix.Entity.Movie;
import org.luiyi.clon_netflix.Repository.CategoryRepository;
import org.luiyi.clon_netflix.Repository.DirectorRepository;
import org.luiyi.clon_netflix.Repository.MovieRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class SwingApp extends JFrame {
    CategoryRepository categoryRepository = new CategoryRepository();
    DirectorRepository directorRepository = new DirectorRepository();
    MovieRepository movieRepository = new MovieRepository();
    private final JTable movieTable;

    public SwingApp() {
        // Configurar la ventana
        setTitle("Gestion de movies");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 230);

        // Crear una tabla para mostrar las peliculas
        movieTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(movieTable);
        add(scrollPane, BorderLayout.CENTER);

        // Crear botones para acciones
        JButton agregarButton = new JButton("Agregar");
        JButton actualizarButton = new JButton("Actualizar");
        JButton eliminarButton = new JButton("Eliminar");

        // Configurar el panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(agregarButton);
        buttonPanel.add(actualizarButton);
        buttonPanel.add(eliminarButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Establecer estilos para los botones
        agregarButton.setBackground(new Color(46, 204, 113));
        agregarButton.setForeground(Color.WHITE);
        agregarButton.setFocusPainted(false);

        actualizarButton.setBackground(new Color(52, 152, 219));
        actualizarButton.setForeground(Color.WHITE);
        actualizarButton.setFocusPainted(false);

        eliminarButton.setBackground(new Color(231, 76, 60));
        eliminarButton.setForeground(Color.WHITE);
        eliminarButton.setFocusPainted(false);

        // Cargar los empleados iniciales en la tabla
        refreshMoviesTable();

        // Agregar ActionListener para los botones
        agregarButton.addActionListener(e -> {
                agregarMovie();
        });

        actualizarButton.addActionListener(e -> actualizarMovie());

        eliminarButton.addActionListener(e -> eliminarMovie());
    }

    private void refreshMoviesTable() {
        // Obtener lista actualizada desde la base de datos
        List<Movie> movies = movieRepository.getMovies();

        // Crear un modelo de tabla y establecer los datos de las movies
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Year");
        model.addColumn("Stars");
        model.addColumn("Category");
        model.addColumn("Director");

        for (Movie movie : movies) {
            Object[] rowData = {
                    movie.getId(),
                    movie.getName(),
                    movie.getYear(),
                    movie.getStars(),
                    movie.getCategory(),
                    movie.getDirector(),
            };
            model.addRow(rowData);
        }
        // Establecer el modelo de tabla actualizado
        movieTable.setModel(model);
    }

    private void agregarMovie() {
        // Crear un formulario para agregar una movie
        JTextField nameField = new JTextField();
        JTextField yearField = new JTextField();
        JTextField starsField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField directorField = new JTextField();

        Object[] fields = {
                "name:", nameField,
                "year:", yearField,
                "stars:", starsField,
                "category:", categoryField,
                "director:", directorField,
        };

        int result = JOptionPane.showConfirmDialog(this, fields, "Agregar Movie", JOptionPane.YES_NO_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            // Crear un nuevo objeto Movie con los datos ingresados
            Movie movie = new Movie();
            movie.setName(nameField.getText());
            movie.setYear(Integer.parseInt(yearField.getText()));
            movie.setStars(Integer.parseInt(starsField.getText()));
            movie.setCategory(Integer.parseInt(categoryField.getText()));
            movie.setDirector(Integer.parseInt(directorField.getText()));

            // Guardar la nueva movie en la base de datos
            movieRepository.insertMovie(movie);

            // Actualizar la tabla con los empleados actualizados
            refreshMoviesTable();

            JOptionPane.showMessageDialog(this, "Movie agregado correctamente", "Exito", JOptionPane.OK_OPTION);
        }
    }

    private void actualizarMovie() {
        // Obtener el id de la movie a actualizar
        String movieIdStr = JOptionPane.showInputDialog(this, "Ingrese el ID de la movie a actualizar", "Actualizar Movie", JOptionPane.OK_OPTION);
        if (movieIdStr != null) {
            try {
                int movieId = Integer.parseInt(movieIdStr);

                // Obtener la movie desde la base de datos
                Movie movie = movieRepository.getMovie(movieId);

                if (movie != null) {
                    // Crear un formulario con los datos del empleado

                    JTextField nameField = new JTextField(movie.getName());
                    JTextField yearField = new JTextField(movie.getYear().toString());
                    JTextField starsField = new JTextField(movie.getStars().toString());
                    JTextField categoryField = new JTextField(movie.getCategory().toString());
                    JTextField directorField = new JTextField(movie.getDirector().toString());

                    Object[] fields = {
                            "name:", nameField,
                            "year:", yearField,
                            "stars:", starsField,
                            "category:", categoryField,
                            "director:", directorField,
                    };

                    int confirmResult = JOptionPane.showConfirmDialog(this, fields, "Actualizar Movie", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (confirmResult == JOptionPane.OK_OPTION) {
                        // Actualizar los datos de la movie con los valores ingresados en el formulario
                        movie.setName(nameField.getText());
                        movie.setYear(Integer.parseInt(yearField.getText()));
                        movie.setStars(Integer.parseInt(starsField.getText()));
                        movie.setCategory(Integer.parseInt(categoryField.getText()));
                        movie.setDirector(Integer.parseInt(directorField.getText()));

                        // Guardar los datos en la base de datos
                        movieRepository.updateMovie(movie);

                        // Actualizar la tabla de movies en la interfaz
                        refreshMoviesTable();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontro ningun empleado con id ", "Error", JOptionPane.OK_CANCEL_OPTION);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingrese un valor numerico valido para el ID", "Error", JOptionPane.OK_OPTION);
            }
        }
    }

    private void eliminarMovie() {
        // movies don't have to be deleted
        JOptionPane.showMessageDialog(this, "Is not possible to delete an movie (requirement of the Product Manager)", "No allowed", JOptionPane.OK_OPTION);

        // Obtener el ID de la movie a eliminar
//        String movieIdStr = JOptionPane.showInputDialog(this, "Ingrese el ID de la movie que desea eliminar", "Eliminar Movie", JOptionPane.OK_CANCEL_OPTION);
//        if (movieIdStr != null) {
//            try {
//                int movieId = Integer.parseInt(movieIdStr);
//
//                // Confirmar eliminacion de la movie
//                int confirmResult = JOptionPane.showConfirmDialog(this, "Esta seguro de que desea eliminar la movie?", "Confirmar Eliminacion", JOptionPane.OK_CANCEL_OPTION);
//                if (confirmResult == JOptionPane.OK_OPTION) {
//                    // Eliminar la movie de la base de datos
//                    JOptionPane.showMessageDialog(this, "Is not possible to delete an movie (requirement of the Product Manager)", "No allowed", JOptionPane.OK_OPTION);
//                    // Actualizar la tabla de empleados de la interfaz
//                    refreshMoviesTable();
//                }
//            } catch (NumberFormatException e) {
//                JOptionPane.showMessageDialog(this, "Ingrese un valor numerico valido para el ID", "Error", JOptionPane.OK_CANCEL_OPTION);
//            }
//        }
    }

}
