package com.example.demo.controller;

import com.example.demo.data.SystemData;
import com.example.demo.service.DownloadService;
import com.example.demo.service.ProjectService;
import com.example.demo.service.UploadService;
import com.example.demo.service.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
public class MainController {
    @Autowired
    UploadService uploadService;
    @Autowired
    DownloadService downloadService;
    @Autowired
    UserService userService;
    @Autowired
    ProjectService projectService;

    @PostMapping("/upload")
    public JSONObject uploadDrawing(HttpServletRequest request, @RequestBody JSONObject jsonObject){
        String username = request.getHeader("username");
        System.out.println(username);
        String userRoute = userService.getUserRoute(username);
        ArrayList<ArrayList<Integer>> points = (ArrayList<ArrayList<Integer>>)jsonObject.get("points");
        String userFilename = jsonObject.getAsString("userFilename");
        System.out.println("List: "+points);

        String filename = uploadService.upload(userRoute, userFilename, points);

        JSONObject obj = new JSONObject();
        obj.put("filename",filename);
        return obj;
    };

    @GetMapping("/download/{filename}")
    public JSONObject downloadDrawing(HttpServletRequest request, @PathVariable String filename){
        String username = request.getHeader("username");
        System.out.println(username);

        String userRoute = userService.getUserRoute(username);

        ArrayList<ArrayList<Integer>> points = downloadService.getPicture(userRoute, filename);

        JSONObject obj = new JSONObject();
        obj.put("result",points);
        return obj;
    };

    @GetMapping("/result/{filename}")
    public JSONObject getRecognizedDrawing(HttpServletRequest request, @PathVariable String filename){
        String username = request.getHeader("username");
        System.out.println(username);
        String userRoute = userService.getUserRoute(username);
        ArrayList<ArrayList<Integer>> points = downloadService.getResult(userRoute, filename);

        JSONObject obj = new JSONObject();
        obj.put("result",points);
        return obj;
    };

    @GetMapping("/shapeName/{filename}")
    public JSONObject getRecognizedName(HttpServletRequest request, @PathVariable String filename){
        String username = request.getHeader("username");
        System.out.println(username);
        String userRoute = userService.getUserRoute(username);
        String name = downloadService.getName(userRoute, filename);

        JSONObject obj = new JSONObject();
        obj.put("result",name);
        return obj;
    };

    @GetMapping("/all")
    public JSONObject getAll(HttpServletRequest request){
        String username = request.getHeader("username");
        System.out.println(username);
        String userRoute = userService.getUserRoute(username);
        ArrayList<String> res = projectService.getUserProjects(userRoute);

        JSONObject obj = new JSONObject();
        obj.put("result",res);
        return obj;
    };

    @GetMapping("/delete/{filename}")
    public JSONObject deleteDrawing(HttpServletRequest request, @PathVariable String filename){
        String username = request.getHeader("username");
        System.out.println(username);
        String userRoute = userService.getUserRoute(username);
        projectService.deleteProject(userRoute, filename);

        JSONObject obj = new JSONObject();
        obj.put("result","");
        return obj;
    };

    @GetMapping("/login/{username}")
    public JSONObject login(HttpServletRequest request){
        String username = request.getHeader("username");
        System.out.println(username);

        userService.login();

        JSONObject obj = new JSONObject();
        obj.put("result","");
        return obj;
    };

}
