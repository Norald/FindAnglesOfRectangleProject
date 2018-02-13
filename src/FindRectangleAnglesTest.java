public class FindRectangleAnglesTest {
    public static void main(String[] args) {
        System.out.println(findTrueAnglesOfRectangle(-1, 0, -1, 4, 2, 4, 4, 1));
        System.out.println(findTrueAnglesOfRectangle(-1, 1, 1, 1, 1, -1, -1, -1));
    }

    //Угол четырехугольника будет прямым, при условии если скалярное произведение векторов, лежащих на прилегающих к нему сторонах, равно нулю.
    // Проверяем, будет ли каждый из четырех углов прямой.
    public static int findTrueAnglesOfRectangle(int x1, int y1, int x2, int y2,int x3, int y3,int x4, int y4){
        int res=0;
        int [] masX= new int[]{x1,x2,x3,x4,0,0};//координаты по оси X
        int [] masY= new int[]{y1,y2,y3,y4,0,0};//координаты по оси Y
        //4 точка равна 0 точке, 5 точка равна 1 точке, необходимо для нахождения скалярного произведения
        masX[4] = masX[0];
        masX[5] = masX[1];
        masY[4] = masY[0];
        masY[5] = masY[1];
        if(Math.abs(x1)>100||Math.abs(x2)>100||Math.abs(x3)>100||Math.abs(x4)>100||Math.abs(y1)>100||Math.abs(y2)>100||Math.abs(y3)>100||Math.abs(y4)>100){
            throw new ArithmeticException("Abs of parameter > 100");
        }
        for(int i = 0; i < 4; i++){
            //Находим скалярное произведение векторов, если оно равно 0, то угол прямой
            if(findScalarValue(masX[i+1]-masX[i], masY[i+1]-masY[i], masX[i+2]-masX[i+1],masY[i+2]-masY[i+1])==0) {
                res++;
            }
        }
        return res;
    }
    private static int findScalarValue(int x1, int y1, int x2, int y2){//метод для поиска скалярного произведения
        return x1*x2+y1*y2;
    }
}
