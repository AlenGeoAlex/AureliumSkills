package com.archyx.aureliumskills.menus;

import com.archyx.aureliumskills.AureliumSkills;
import com.archyx.aureliumskills.menus.common.CloseItem;
import com.archyx.aureliumskills.menus.contexts.SkillContext;
import com.archyx.aureliumskills.menus.skills.ClickableSkillItem;
import com.archyx.aureliumskills.menus.skills.SkillsMenu;
import com.archyx.aureliumskills.menus.skills.YourSkillsItem;
import com.archyx.aureliumskills.skills.Skill;
import com.archyx.slate.Slate;
import com.archyx.slate.context.ContextManager;
import com.archyx.slate.menu.MenuManager;

public class MenuRegistrar {

    private final AureliumSkills plugin;
    private final Slate slate;

    public MenuRegistrar(AureliumSkills plugin) {
        this.plugin = plugin;
        this.slate = plugin.getSlate();
    }

    public void register() {
        ContextManager contextManager = slate.getContextManager();
        // Register contexts
        contextManager.registerContext(Skill.class, new SkillContext(plugin));

        MenuManager menuManager = slate.getMenuManager();
        // Register menus
        menuManager.registerMenuProvider("skills", new SkillsMenu(plugin));
        // Register items
        menuManager.registerItemProvider("your_skills", new YourSkillsItem(plugin));
        menuManager.registerItemProvider("skill", new ClickableSkillItem(plugin));
        menuManager.registerItemProvider("close", new CloseItem(plugin));
    }
}