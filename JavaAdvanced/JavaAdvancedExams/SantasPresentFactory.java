import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class SantasPresentFactory {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
     ArrayDeque<Integer> materials = new ArrayDeque<>();
     Arrays.stream(bf.readLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(materials::push);
     ArrayDeque<Integer> magic = new ArrayDeque<>();
     Arrays.stream(bf.readLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(magic::offer);
     Map<String, Integer> toys = new TreeMap<>();
     toys.put("Doll: ",0 );
     toys.put("Bicycle: ", 0);
     toys.put("Teddy bear: ", 0);
     toys.put("Wooden train: ", 0);

     while (!magic.isEmpty()&&!materials.isEmpty()){
         int currentMaterial = materials.peek();
         int currentMagic = magic.peek();
         if(currentMaterial==0||currentMagic==0){
             if(currentMaterial==0){
                 materials.pop();
             }
             if(currentMagic==0){
                 magic.poll();
             }

             continue;
         }
         int result = currentMagic*currentMaterial;
         magic.poll();
         materials.pop();

         if(result<0){
             result=currentMagic+currentMaterial;
             materials.push(result);
         }else if(result==150){
             toys.put("Doll: ", toys.get("Doll: ")+1);

         }else if(result==250){
            toys.put("Wooden train: ", toys.get("Wooden train: ")+1);
         }else if(result==300){
             toys.put("Teddy bear: ", toys.get("Teddy bear: ")+1);
         }else if(result==400){
             toys.put("Bicycle: ", toys.get("Bicycle: ")+1);
         }else{
             materials.push(currentMaterial+15);
         }

     }
     if((toys.get("Doll: ")>0&&toys.get("Wooden train: ")>0)||(toys.get("Bicycle: ")>0&&toys.get("Teddy bear: ")>0)){
         System.out.println("The presents are crafted! Merry Christmas!");
     }else{
         System.out.println("No presents this Christmas!");
     }
     if(!materials.isEmpty()){
         List<String> stringMaterials = materials.stream().map(String::valueOf).collect(Collectors.toList());
         System.out.print("Materials left: ");
         System.out.print(String.join(", ", stringMaterials));
         System.out.println();
     }
     if(!magic.isEmpty()){
         List<String> stringMagic = magic.stream().map(String::valueOf).collect(Collectors.toList());
         System.out.print("Magic left: ");
         System.out.print(String.join(", ", stringMagic));
         System.out.println();

     }
   toys.entrySet().stream().filter(toy->toy.getValue()>0).forEach(t->{
       System.out.println(t.getKey()+t.getValue());
   });

    }
}
