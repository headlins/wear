package educar.controllers.AdminController;

import java.awt.Dimension;
import java.awt.List;
import java.sql.SQLException;

import educar.controllers.IController;
import educar.gui.IView;
import educar.gui.AdminViews.administrador;
import educar.languaje.defaultLanguaje;
import educar.models.Alumno;

public class gestionAlumnosController implements IController, defaultLanguaje {
    private administrador view;
    private static Alumno student = null;
    private static List studentsList;

    @Override
    public void process(String model) {
	// TODO agregar alumno
	if (model.compareTo(ADD) == 0) {
	    AddStudent();
	}
	if (model.compareTo(DELETE) == 0) {
	    deletStudent();
	    showStudentInList();
	}
	if (model.compareTo(SEARCH) == 0) {
	    searchAStudentInDbase();
	}
	if (model.compareTo(MODIFY) == 0) {
	    showStudentInList();
	    modifyStudent();
	}
	if (model.compareTo(CLEAR) == 0) {
	    view.deleteViewFieldsAlta_A();
	}

    }

    private void searchAStudentInDbase() {
	// TODO Auto-generated method stub
	student = Alumno.getAlumno(view.getDniMod_A());
	if (student != null) {
	    view.setTfNombre_modif_A(student.getName());
	    view.setTfApellido_modif_A(student.getLastName());
	    view.setTfDireccion_modif_A(student.getDir());
	    view.setTfDni_modif_A(student.getDni());
	    view.setTfFechaNac_modif_A(student.getfN());
	    view.setTfTelefono_modif_A(student.getTel());
	} else {
	    view.present("El dni del alumno no existe ");
	    view.deleteViewFieldsMod_A();
	}

    }

    // se supones que tiene un alumno lo borro student tiene un alumno
    private void deletStudent() {//
	searchAStudentInDbase();
	if (!(view.getDniMod_A().compareTo("") == 0)) {// si no tengo un
	    // documento
	    // en
	    // pantalla es porque no pudo
	    // encontrar el alumno
	    if (student.destroy()) {
		view.present("borrado del alumno exitoso");
		view.deleteViewFieldsMod_A();
	    }

	}

    }

    @Override
    public void setView(IView view) {
	// TODO Auto-generated method stub
	this.view = (administrador) view;
    }

    private void AddStudent() {
	// TODO ("3563", "xxx", "xxx","2000-12-12","xxx","xxx") falta
	if (view.fieldsIsOkAlta_A()) {// si no ingreso algun campo no permite
	    // guardad
	    Alumno alumno = new Alumno(view.getDniAlta_A(), view
		    .getNameAlta_A(), view.getLastnameAlta_A(), view
		    .getFechaNacAlta_A(), view.getTelefonoAlta_A(), view
		    .getDireccionAlta_A());
	    if (alumno.save()) {
		view
			.present("alumno agregado correctamente. Se creo el Usuario para el alumno ");

	    } else {
		// datos ingresados no son validos hacer una funcion que avise
		// que
		// campo esta mal!
		view.present("verifique los datos ingresados sean validos");
	    }
	} else
	    view.present("faltan completar campos");
    }

    private void modifyStudent() {// ponerle la edad !!!!
	student = Alumno.getAlumno(view.getDniMod_A());
	if (student != null) {
	    String[] values = { view.getDniMod_A(), view.getLastnameMod_A(),
		    view.getNameMod_A(), view.getFechaNacMod_A(),
		    view.getTelefonoMod_A(), view.getDireccionMod_A() };

	    try {
		Alumno.update(values, student.getDni());
		view.present("acutalizacion realizada");
	    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		view.present("NO se pude actualizar");
	    }
	    // view.deleteViewFieldsMod();
	} else {
	    view.present("el alumno no existe");
	}
    }

    // si se selecciono un estudiante de la lista lo que tengo que hacer es
    // poner su numero de documento en la solapa de busacar para que despues el
    // usuario o administrador lo busque
    // asumo que cuando se clicque dos veces sobre un docente lo que hace la
    // view es poner en el campo BUSCAR el dni del alumno
    private void StudentSelectedFromList() {
	student = Alumno.getAlumno(view.getDniAlta_A());
	if (student != null) {
	    this.setFieldModifyStudentView();
	}
    }

    private void showStudentInList() {
	try {
	    studentsList = Alumno.ListAlumnos();
	    view.setListAlumnos_ABM(studentsList);
	} catch (SQLException e) {
	    view.present("no entro por la lista de alumnos");
	}
    }

    private void setFieldModifyStudentView() {
	view.setTfNombre_modif_A(student.getName());
	view.setTfApellido_modif_A(student.getLastName());
	view.setTfDireccion_modif_A(student.getDir());
	view.setTfDni_modif_A(student.getDni());
	view.setTfFechaNac_modif_A(student.getfN());
	view.setTfTelefono_modif_A(student.getTel());
    }
}