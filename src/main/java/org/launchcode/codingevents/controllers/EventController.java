package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping
    public String displayAllEvents(Model model) {
<<<<<<< HEAD


        model.addAttribute("events", events);
=======
        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventData.getAll());
>>>>>>> 1f8c4736a13564e91b6e04cc8b729f23196e3a4d
        return "events/index";
    }

    // lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm(Model model) {
        model.addAttribute("title", "Create Events");
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute Event newEvent) {
        EventData.add(newEvent);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDelteEventsForm(@RequestParam(required = false) int[] eventIds) {

        if (eventIds != null) {
            for(int id : eventIds) {
                EventData.remove(id);
            }
        }


        return "redirect:";
    }
}
