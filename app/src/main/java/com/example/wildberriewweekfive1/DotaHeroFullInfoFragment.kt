package com.example.wildberriewweekfive1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.example.wildberriewweekfive1.databinding.FragmentDotaHeroFullInfoBinding


class DotaHeroFullInfoFragment : Fragment() {
    lateinit var binding: FragmentDotaHeroFullInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDotaHeroFullInfoBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = this.arguments
        val name = bundle?.getString("name")
        val image = bundle?.getString("image")
        val attackRange = bundle?.getString("attackRange")
        val attackRate = bundle?.getString("attackRate")
        val baseHealth = bundle?.getString("BaseHealth")
        val baseHealthRegen = bundle?.getString("BaseHealthRegen")
        val baseMana = bundle?.getString("BaseMana")
        val baseManaRegen = bundle?.getString("BaseManaRegen")
        val moveSpeed = bundle?.getString("MoveSpeed")

        with(binding){
            tvNameSecondFragment.text = name
            tvAttackRange.text = "Attack Range: $attackRange"
            tvAttackRate.text = "Attack Rate: $attackRate"
            tvBaseHealth.text = "Base Health: $baseHealth"
            tvBaseHealthRegen.text = "Base Health Regen: $baseHealthRegen"
            tvBaseMana.text = "Base Mana: $baseMana"
            tvBaseManaRegen.text = "Base Mana Regenbase: $baseManaRegen"
            tvMoveSpeed.text = "Move Speed: $moveSpeed"
            imageView.load("https://api.opendota.com${image}")
        }

        /*
        bundle.putString("name", dotaHero.name)
                    bundle.putString("image", dotaHero.img)
                    bundle.putString("attackRange", dotaHero.attack_range.toString())
                    bundle.putString("attackRate", dotaHero.attack_rate.toString())
                    bundle.putString("BaseHealth", dotaHero.base_health.toString())
                    bundle.putString("BaseHealthRegen", dotaHero.base_health_regen.toString())
                    bundle.putString("BaseMana", dotaHero.base_mana.toString())
                    bundle.putString("BaseManaRegen", dotaHero.base_mana_regen.toString())
                    bundle.putString("MoveSpeed", dotaHero.move_speed.toString())*/


    }

    companion object {
        @JvmStatic
        fun newInstance() = DotaHeroFullInfoFragment()
    }
}