package bs;
import Dao.ContactoDao;
import Bean.Contacto;
public class ContactoBs {
			
	public int registraContacto(Contacto contacto)
		{
			ContactoDao contactoDao = new ContactoDao();
			int codigo=(Integer)contactoDao.registrarContacto(contacto);
			return codigo;
		}
	public int actualizaPersona(Contacto contacto)
	{
		ContactoDao contactoDao = new ContactoDao();
		int codigo=(Integer)contactoDao.actualizaPersona(contacto);
		return codigo;
	}
	public int borrar(Contacto contacto)
	{
		ContactoDao contactoDao = new ContactoDao();
		int codigo=(Integer)contactoDao.borrar(contacto);
		return codigo;
	}
		public Contacto findById(Integer id)
		{
			ContactoDao contactoDAO = new ContactoDao();
			Contacto contacto;
			contacto = contactoDAO.findbyId(id);
			System.out.println("--->BS.contacto" + contacto);
			return contacto;
		}
		
		public static void main(String[] args)
		{
			ContactoDao contactoDao = new ContactoDao();
			Contacto contacto;
			contacto = contactoDao.findbyId(1);
			if(contacto != null)
			{
				System.out.println("Calle: " + contacto.getTelefono());
				System.out.println("Colonia" + contacto.getCorreo());
			}
			else
			{
				System.out.println("Se genero algun error");
			}
		}	
	}