package b6.ke_thua.thuc_hanh.doi_tuong_hinh_hoc;

public class circle_shape {
    public static void main(String[] args) {
        circle circle =new circle();
        System.out.println(circle);

        circle= new circle(3.5);
        System.out.println(circle);

        circle= new circle(3.5,"indigo",false);
        System.out.println(circle);
    }
}
