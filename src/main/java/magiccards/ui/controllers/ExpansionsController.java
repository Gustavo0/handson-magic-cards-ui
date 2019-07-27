package magiccards.ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import magiccards.ui.entities.Expansion;
import magiccards.ui.entities.Page;
import magiccards.ui.entities.TablePage;
import magiccards.ui.proxies.ExpansionsFacadeProxy;

@Controller
@RequestMapping(path="/expansions")
public class ExpansionsController {

    @Autowired
    private ExpansionsFacadeProxy expansionsFacadeProxy;

    @GetMapping
    public String list() {
        return "expansions/list";
    }

    @RequestMapping(value="/data", method = RequestMethod.GET)
    public @ResponseBody TablePage<Expansion> listPaged(@RequestParam("draw")int draw, @RequestParam("start")int start,@RequestParam("length")int length) {

        int pageNumber = (start/length) + 1;
        Page<Expansion> expansions = expansionsFacadeProxy.getExpansions(pageNumber, length);

        TablePage<Expansion> result = new TablePage<Expansion>();
        result.setData(expansions.getContent());
        result.setRecordsTotal(expansions.getTotalElements());
        result.setRecordsFiltered(expansions.getTotalElements());
        result.setDraw(draw);
        return result;
    }

    @RequestMapping(value="/create", method = RequestMethod.GET)
    public String create() {
        return "expansions/create";
    }

    @RequestMapping(value="/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id")String id, Model model) {

        Expansion expansion = expansionsFacadeProxy.getExpansionById(id);
        model.addAttribute("expansion", expansion);
        return "expansions/update";
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public String create(Expansion expansion) {

        expansionsFacadeProxy.create(expansion);

        return "redirect:/expansions";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String update(Expansion expansion) {

        expansionsFacadeProxy.update(expansion);

        return "redirect:/expansions";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id")String id) {

        expansionsFacadeProxy.delete(id);

        return "redirect:/expansions";
    }


}
