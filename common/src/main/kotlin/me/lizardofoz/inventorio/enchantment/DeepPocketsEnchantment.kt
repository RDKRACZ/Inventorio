package me.lizardofoz.inventorio.enchantment

import me.lizardofoz.inventorio.config.GlobalSettings
import me.lizardofoz.inventorio.util.DEEP_POCKETS_MAX_LEVEL
import me.lizardofoz.inventorio.util.DeepPocketsMode
import net.minecraft.enchantment.Enchantment
import net.minecraft.enchantment.EnchantmentTarget
import net.minecraft.entity.EquipmentSlot

object DeepPocketsEnchantment : Enchantment(Rarity.RARE, EnchantmentTarget.ARMOR_LEGS, arrayOf(EquipmentSlot.LEGS))
{
    private val isEnabled = GlobalSettings.deepPocketsInSurvival.value == DeepPocketsMode.ENABLED

    override fun getMinLevel(): Int
    {
        return 1
    }

    override fun getMaxLevel(): Int
    {
        return DEEP_POCKETS_MAX_LEVEL
    }

    override fun getMinPower(level: Int): Int
    {
        return level * 25
    }

    override fun getMaxPower(level: Int): Int
    {
        return getMinPower(level) + 50
    }

    override fun isTreasure(): Boolean
    {
        return isEnabled
    }

    override fun isAvailableForEnchantedBookOffer(): Boolean
    {
        return isEnabled
    }

    override fun isAvailableForRandomSelection(): Boolean
    {
        return isEnabled
    }
}