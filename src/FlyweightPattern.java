import java.util.ArrayList;
import java.util.List;

//享元工厂
class Library {
    //可借的书,书池，借书时如果书池中有要借的书，就不用生产新书了
    private List<Book> bookList = new ArrayList<Book>();
    //借书出去
    public Book borrowBook(Class clazz) {
        for(Book book : bookList) {
            if(clazz.isInstance(book)) {
                bookList.remove(book);
                book.borrow();
                return book;
            }
        }
        //没有找到要借的书，生产一本
        try {
            Book book = (Book) clazz.newInstance();
            book.borrow();
            return book;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    //还书回来
    public void returnBook(Book returnBook) {
        //放入书架
        bookList.add(returnBook);
        returnBook.returnBook();
    }
}
//享元接口（书），可以借书和还书
interface Book {
    void borrow();
    void returnBook();
}
//数学书
class MathBook implements Book {
    public MathBook() {
        System.out.println("create " + getClass().getName());
    }

    @Override
    public void borrow() {
        System.out.println("borrow " + getClass().getName());
    }

    @Override
    public void returnBook() {
        System.out.println("return " + getClass().getName());
    }
}
//漫画书
class ComicBook implements Book {
    public ComicBook() {
        System.out.println("create " + getClass().getName());
    }

    @Override
    public void borrow() {
        System.out.println("borrow " + getClass().getName());
    }

    @Override
    public void returnBook() {
        System.out.println("return " + getClass().getName());
    }
}